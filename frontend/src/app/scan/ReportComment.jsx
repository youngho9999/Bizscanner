import React, { forwardRef, useEffect, useRef, useState } from 'react';
import ReportSection from './ReportSection';
import SendIcon from '@/assets/icons/Send.svg';
import axios from '@/api/index';
import { useSearchState } from './SearchContext';

function ReportCommentItem({ nickName, contents }) {
  return (
    <div className="py-4 border-b border-black">
      <div className="text-xl font-bold">{nickName}</div>
      <div>{contents}</div>
    </div>
  );
}

const CommentInput = forwardRef(function CommentInput({ placeholder, fetchComments }, ref) {
  const { careaCode, jcategoryCode } = useSearchState();

  const inputRef = useRef(null);
  const onClickSendComment = async () => {
    const value = inputRef.current.value;

    await axios.post(`/comment`, {
      careaCode,
      jcategoryCode,
      contents: value,
    });

    fetchComments();

    inputRef.current.value = '';
  };

  return (
    <div className="flex items-center h-12 px-4 overflow-hidden border rounded-full border-outline">
      <input placeholder={placeholder} className="h-full grow outline-0" ref={inputRef} />
      <button
        className="relative flex items-center w-8 h-8 p-1 ml-1 rounded-full bg-primary"
        onClick={onClickSendComment}
      >
        <SendIcon width="22" className="absolute right-[6px]" />
      </button>
    </div>
  );
});

function ReportComment() {
  const [comments, setComments] = useState([]);
  const { careaCode } = useSearchState();

  const fetchComments = async () => {
    const {
      data: { commentResponseList },
    } = await axios.get(`/comment/${careaCode}`);
    setComments(commentResponseList);
  };

  useEffect(() => {
    fetchComments();
  }, []);
  return (
    <ReportSection title="코멘트" className="h-full">
      <div className="overflow-auto h-[80%] scrollbar-hide mb-4">
        {comments.length &&
          comments.map(({ nickname, contents }) => (
            <ReportCommentItem nickName={nickname} contents={contents} />
          ))}
      </div>
      <CommentInput placeholder="댓글 추가" fetchComments={fetchComments} />
    </ReportSection>
  );
}

export default ReportComment;
